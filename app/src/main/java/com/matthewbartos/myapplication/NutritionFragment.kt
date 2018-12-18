package com.matthewbartos.myapplication

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_nutrition.*

class NutritionFragment : Fragment() {

    companion object {
        const val TAG = "NutritionFragment"
        private const val FIRST_CATEGORIES_INDEX = 1
        private const val LAST_CATEGORIES_INDEX = 20
        private const val FIRST_PROGRAMS_INDEX = 1
        private const val LAST_PROGRAMS_INDEX = 50
        private const val PROGRAM_COLUMNS = 4
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_nutrition, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoriesList = generateMockedStringList(FIRST_CATEGORIES_INDEX, LAST_CATEGORIES_INDEX)
        val programsList = generateMockedStringList(FIRST_PROGRAMS_INDEX, LAST_PROGRAMS_INDEX)

        // TODO Remove duplicated code
        val categoriesLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
        categories_recycler_view.layoutManager = categoriesLayoutManager
        val categoriesAdapter = CategoryItemAdapter(categoriesList, requireContext())
        categories_recycler_view.adapter = categoriesAdapter
        categoriesAdapter.currentPosition.observe(this, Observer {
            println(it)
        })

        categories_recycler_view.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {

                // Check if child is visible
                // If yes, focus child
                // If not, scroll to child (async) and focus child
                // Keep current focus position

                val position = categoriesAdapter.currentPosition.value ?: 0

                categoriesLayoutManager.scrollToPosition(position)
                categoriesLayoutManager.findViewByPosition(position)?.requestFocus()
            }
        }

        val layoutManager = GridLayoutManager(context, PROGRAM_COLUMNS)
        programs_recycler_view.layoutManager = layoutManager
        val programsAdapter = ProgramItemAdapter(programsList, requireContext())
        programs_recycler_view.adapter = programsAdapter

        programs_recycler_view.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                layoutManager.scrollToPosition(0)
                layoutManager.findViewByPosition(0)?.requestFocus()
            }
        }
    }

    private fun generateMockedStringList(start: Int, end: Int): List<String> {
        return (start..end)
            .map { it.toString() }
            .toList()
    }
}

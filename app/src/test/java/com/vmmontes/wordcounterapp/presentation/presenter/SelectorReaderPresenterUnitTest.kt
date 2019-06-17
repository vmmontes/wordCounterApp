package com.vmmontes.wordcounterapp.presentation.presenter

import com.vmmontes.wordcounterapp.domain.usecase.CleanLocalWordsUseCase
import com.vmmontes.wordcounterapp.presentation.ui.selectorReader.SelectorReaderView
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class SelectorReaderPresenterUnitTest {
    private lateinit var mockCleanLocalWordsUseCase: CleanLocalWordsUseCase
    private lateinit var view: SelectorReaderView
    private lateinit var presenter: SelectorReaderPresenter

    @Before
    fun setup() {
        mockCleanLocalWordsUseCase = Mockito.mock(CleanLocalWordsUseCase::class.java)
        view = Mockito.mock(SelectorReaderView::class.java)
        presenter = SelectorReaderPresenter(mockCleanLocalWordsUseCase)
    }

    @Test
    fun `should execute right worklow when call readSmallFileAction`() {
        // arrange
        presenter.onAttach(view)

        // act
        presenter.readSmallFileAction()

        // assert
        Mockito.verify(view, Mockito.times(1)).openReaderViewToShowTextFromSmallFile()
        Mockito.verify(view, Mockito.times(0)).openReaderViewToShowTextFromBigFile()
    }

    @Test
    fun `should execute right worklow when call readBigFileAction`() {
        // arrange
        presenter.onAttach(view)

        // act
        presenter.readBigFileAction()

        // assert
        Mockito.verify(view, Mockito.times(0)).openReaderViewToShowTextFromSmallFile()
        Mockito.verify(view, Mockito.times(1)).openReaderViewToShowTextFromBigFile()
    }
}

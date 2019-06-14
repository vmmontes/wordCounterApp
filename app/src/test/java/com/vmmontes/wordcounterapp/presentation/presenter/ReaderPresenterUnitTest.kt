package com.vmmontes.wordcounterapp.presentation.presenter

import com.vmmontes.wordcounterapp.domain.usecase.CleanLocalWordsUseCase
import com.vmmontes.wordcounterapp.domain.usecase.GetLocalWordsUseCase
import com.vmmontes.wordcounterapp.domain.usecase.GetWordsUseCase
import com.vmmontes.wordcounterapp.presentation.model.WordViewModel
import com.vmmontes.wordcounterapp.presentation.ui.reader.ReaderView
import com.vmmontes.wordcounterapp.presentation.ui.selectorReader.SelectorReaderView
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class ReaderPresenterUnitTest {
    private lateinit var mockGetWordsUseCase: GetWordsUseCase
    private lateinit var mockGetLocalWordsUseCase: GetLocalWordsUseCase
    private lateinit var view: ReaderView
    private lateinit var presenter: ReaderPresenter

    @Before
    fun setup() {
        mockGetWordsUseCase = Mockito.mock(GetWordsUseCase::class.java)
        mockGetLocalWordsUseCase = Mockito.mock(GetLocalWordsUseCase::class.java)
        view = Mockito.mock(ReaderView::class.java)
        presenter = ReaderPresenter(mockGetWordsUseCase, mockGetLocalWordsUseCase)
    }

   /* private fun getData():
    fun getData(): Observable<String> {
        return dummyService.getData()
    }

    @Test
    fun `should execute right worklow when call onViewReadyToShowTextFromBigFile and local list of words not contians words`() {
        // arrange
        val wordsListVoid = mutableListOf<WordViewModel>()
        val wordsListFill = mutableListOf<WordViewModel>()
        wordsListFill.add(WordViewModel("prueba", 100))

        val dummyService = Mockito.mock(Dummy)
        presenter.onAttach(view)
        Mockito.`when`(mockGetLocalWordsUseCase.execute()).thenReturn(wordsListVoid)
        Mockito.`when`(mockGetWordsUseCase.execute(GetWordsUseCase.FILE_TYPE.BIG_FILE)).thenReturn(Observable<MutableList<WordViewModel>>())

        // act
        presenter.onViewReadyToShowTextFromBigFile()

        // assert
        Mockito.verify(view, Mockito.times(1)).showWords()
        Mockito.verify(view, Mockito.times(0)).openReaderViewToShowTextFromBigFile()
    }*/
}

package com.vmmontes.wordcounterapp.presentation.presenter

import com.vmmontes.wordcounterapp.domain.usecase.GetLocalWordsUseCase
import com.vmmontes.wordcounterapp.domain.usecase.GetWordsUseCase
import com.vmmontes.wordcounterapp.kernel.rx.TrampolineSchedulerProvider
import com.vmmontes.wordcounterapp.presentation.model.WordViewModel
import com.vmmontes.wordcounterapp.presentation.ui.reader.ReaderView
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class ReaderPresenterUnitTest {
    private lateinit var mockGetWordsUseCase: GetWordsUseCase
    private lateinit var mockGetLocalWordsUseCase: GetLocalWordsUseCase
    private lateinit var view: ReaderView
    private lateinit var presenter: ReaderPresenter
    private var schedulerProvider = TrampolineSchedulerProvider()

    @Before
    fun setup() {
        mockGetWordsUseCase = Mockito.mock(GetWordsUseCase::class.java)
        mockGetLocalWordsUseCase = Mockito.mock(GetLocalWordsUseCase::class.java)
        view = Mockito.mock(ReaderView::class.java)
        presenter = ReaderPresenter(mockGetWordsUseCase, mockGetLocalWordsUseCase)
    }

    private fun getMockObservable(words: MutableList<WordViewModel>): Observable<MutableList<WordViewModel>> {
        return Observable.create<MutableList<WordViewModel>> {
            for(i in 0..2){
                it.onNext(words)
            }
        }.subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
    }

    @Test
    fun `should execute showWords with filWord three times`() {
        // arrange
        presenter.onAttach(view)
        val localWords = mutableListOf<WordViewModel>()
        val fileWords = mutableListOf<WordViewModel>()
        fileWords.add(WordViewModel("Prueba", 2))
        Mockito.`when`(mockGetLocalWordsUseCase.execute())
            .thenReturn(localWords)
        Mockito.`when`(mockGetWordsUseCase.execute(GetWordsUseCase.FILE_TYPE.BIG_FILE))
            .thenReturn(getMockObservable(fileWords))

        //act
        presenter.onViewReadyToShowTextFromBigFile()

        // assert
        Mockito.verify(view, Mockito.times(3)).showWords(fileWords)
        Mockito.verify(view, Mockito.times(0)).showWords(localWords)
    }

    @Test
    fun `should execute showWords with localWords three times`() {
        // arrange
        presenter.onAttach(view)
        val localWords = mutableListOf<WordViewModel>()
        localWords.add(WordViewModel("Prueba", 2))
        val fileWords = mutableListOf<WordViewModel>()
        Mockito.`when`(mockGetLocalWordsUseCase.execute())
            .thenReturn(localWords)

        //act
        presenter.onViewReadyToShowTextFromBigFile()

        // assert
        Mockito.verify(view, Mockito.times(0)).showWords(fileWords)
        Mockito.verify(view, Mockito.times(1)).showWords(localWords)
    }
}

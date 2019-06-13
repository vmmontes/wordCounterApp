package com.vmmontes.wordcounterapp.kernel.presenter

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class RxPresenter<T> :Presenter<T>() {
    private lateinit var disposables: CompositeDisposable

    override fun onAttach(view: T) {
        super.onAttach(view)
        disposables = CompositeDisposable()
    }

    override fun onDetach() {
        super.onDetach()
        disposables.dispose()
    }

    fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }
}
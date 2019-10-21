package com.example.mockitokotlinsample

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test

import org.junit.Assert.*


class MainPresenterTest {

    /*
     *今後テストするメソッドが増えることを想定してグローバル宣言
     */

    //モッククラス生成
    private val repositoryMock = mock<SampleRepository> {
        on { getUserById(1) } doReturn "taro"
        on { getUserById(0) } doReturn "error"
    }
    private val viewMock = mock<MainContact.View> {}

    //テスト対象クラス
    private val mainPresenter:MainPresenter = MainPresenter(viewMock, repositoryMock)


    /*
     * getNameのテスト実行
     *　getName()の引数が１の場合、２の場合をテスト
     */
    @Test
    fun getNameTest() {

        //メソッド実行
        val test1 = mainPresenter.getName(1)
        val test2 = mainPresenter.getName(0)

        //指定のクラスが呼ばれたか
        verify(repositoryMock, times(1)).getUserById(1)

        //戻り値確認
        assertEquals("taro", test1)
        assertEquals("error", test2)
    }
}
package uk.co.mali.domain

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.runners.MockitoJUnitRunner
import uk.co.mali.domain.usecase.TraktUseCase

/**
 * Created by alig2 on 20/08/2017.
 */

@RunWith(MockitoJUnitRunner::class)
class TraktUseCaseTest() {


    var usecase: TraktUseCase? = null

    @Before
    fun setup() {

        //     usecase = TraktUseCase(TraktUseCase.internetScheduler,repository)
    }


    @Test
    fun should_Pass_Trakt_Observable_To_Disposable_Observer() {
        //  val repository = mock(IDataRepository::class)

        //Mockito.verifyNoMoreInteractions(repository)    }

        // do to

    }
}

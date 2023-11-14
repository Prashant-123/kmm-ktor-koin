package ui.internships

import com.rickclephas.kmm.viewmodel.KMMViewModel
import domain.usecase.StreamInternshipUseCase

class InternshipViewModel(streamInternshipUseCase: StreamInternshipUseCase) : KMMViewModel() {
    val internships = streamInternshipUseCase()
}
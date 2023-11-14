package domain.usecase

import domain.Repository

class StreamInternshipUseCase(private val repository: Repository) {
    operator fun invoke() = repository.streamInternships()
}
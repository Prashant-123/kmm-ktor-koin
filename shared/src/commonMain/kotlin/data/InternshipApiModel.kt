package data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InternshipApiModel(
    @SerialName("internships_meta")
    val internshipsMeta: Map<String, Internship>
) {
    @Serializable
    data class Internship(
        @SerialName("company_logo")
        val companyLogo: String,
        @SerialName("company_name")
        val companyName: String,
        @SerialName("duration")
        val duration: String,
        @SerialName("id")
        val id: Int,
        @SerialName("posted_by_label")
        val postedByLabel: String,
        @SerialName("profile_name")
        val profileName: String,
        @SerialName("start_date")
        val startDate: String,
        @SerialName("stipend")
        val stipend: Stipend?,
        @SerialName("title")
        val title: String,
        @SerialName("url")
        val url: String,
        @SerialName("labels_app_in_card")
        val labels: List<String>? = null
    ) {
        @Serializable
        data class Stipend(
            @SerialName("large_stipend_text")
            val largeStipendText: Boolean?,
            @SerialName("salary")
            val salary: String?,
            @SerialName("salaryType")
            val salaryType: String?,
            @SerialName("tooltip")
            val tooltip: String?
        )
    }
}
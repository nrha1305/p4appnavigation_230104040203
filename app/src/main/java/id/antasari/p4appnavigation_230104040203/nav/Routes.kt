package id.antasari.p4appnavigation_230104040203.nav

// Rute dasar untuk 12 layar kita (sementara cukup ini dulu)
sealed class Route(val path: String) {
    data object Home : Route("home")

    // A/B (Explicit Intent demo)
    data object ActivityA : Route("activity_a")
    data object ActivityB : Route("activity_b")

    // C/D (Send Data)
    data object ActivityC : Route("activity_c")
    data object ActivityD : Route("activity_d/{name}/{studentId}"){
        fun make(name: String, studentId: String): String =
            "activity_d/${name.urlEnc()}/${studentId.urlEnc()}"
    }

    // Back Stack demo
    data object Step1 : Route("step_1")
    data object Step2 : Route("step_2")
    data object Step3 : Route("step_3")

    // Hub (Activity + Fragment style)
    data object Hub : Route("hub")
    data object HubDashboard : Route("hub/dashboard")
    data object HubMessages : Route("hub/messages")
    data object HubProfile : Route("hub/profile")
    data object HubMsgDetail : Route("hub/messages/{id}") {
        fun of(id: String): String = "hub/messages/$id"
    }
}

private fun String.urlEnc(): String = java.net.URLEncoder.encode(this, "utf-8")
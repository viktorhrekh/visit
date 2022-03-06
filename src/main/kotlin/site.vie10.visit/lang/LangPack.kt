package site.vie10.visit.lang

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @author vie10
 **/
@Serializable
data class LangPack(
    @SerialName("code")
    val code: String,
    @SerialName("word")
    val word: Word,
    @SerialName("text")
    val text: Text
) {

    @Serializable
    data class Word(
        @SerialName("settings")
        val settings: String,
        @SerialName("mode")
        val mode: String,
        @SerialName("light")
        val light: String,
        @SerialName("dark")
        val dark: String,
        @SerialName("english")
        val english: String,
        @SerialName("ukrainian")
        val ukrainian: String,
        @SerialName("language")
        val language: String,
        @SerialName("linked_in")
        val linkedIn: String,
        @SerialName("git_hub")
        val gitHub: String,
        @SerialName("telegram")
        val telegram: String,
        @SerialName("pdf")
        val pdf: String,
        @SerialName("yes")
        val yes: String
    )

    @Serializable
    data class Text(
        @SerialName("full_name")
        val fullName: String,
        @SerialName("dev_label")
        val devLabel: String,
        @SerialName("telegram_link")
        val telegramLink: String,
        @SerialName("git_hub_link")
        val gitHubLink: String,
        @SerialName("linked_in_link")
        val linkedInLink: String,
        @SerialName("kotlin_dev")
        val kotlinDev: String,
        @SerialName("first_tip")
        val firstTip: String,
        @SerialName("is_it_right")
        val isItRight: String
    )
}

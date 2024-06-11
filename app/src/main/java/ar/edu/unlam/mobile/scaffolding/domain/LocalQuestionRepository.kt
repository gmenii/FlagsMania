package ar.edu.unlam.mobile.scaffolding.domain

class LocalQuestionRepository : IQuestionRepository {
    override fun getAllOptions(): ArrayList<CountryOption> {
        // @FIXME: modificar para que del listado completo las mezcle y tome 10.
        return arrayListOf(
            CountryOption("USA", "us_flag.png", "Washington"),
            CountryOption("France", "fr_flag.png", "Paris"),
            CountryOption("Germany", "de_flag.png", "Berlin"),
            CountryOption("Japan", "jp_flag.png", "Tokyo"),
            CountryOption("Australia", "au_flag.png", "Sydney"),
            CountryOption("Brazil", "br_flag.png", "Brasilia"),
            CountryOption("Italy", "it_flag.png", "Rome"),
            CountryOption("Canada", "ca_flag.png", "Ottawa"),
            CountryOption("Spain", "es_flag.png", "Madrid"),
            CountryOption("China", "cn_flag.png", "Beijing"),
        )
    }
}

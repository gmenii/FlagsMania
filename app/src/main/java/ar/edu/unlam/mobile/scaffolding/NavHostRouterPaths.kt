package ar.edu.unlam.mobile.scaffolding

enum class NavHostRouterPaths(val route: String) {
    HOME("home"),
    GAME_CLASSIC("GameClassic"),
    GAME_ADVANCED("GameAdvanced"),
    GAME_RESULT("GameResult/{gameType}"),
    GAME_CLASSIC_RULES("GameClassicRules"),
    GAME_ADVANCED_RULES("GameAdvancedRules"),
}

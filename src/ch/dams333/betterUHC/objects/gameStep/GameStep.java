package ch.dams333.betterUHC.objects.gameStep;

public enum GameStep {

    PREGAME("Pregame"),
    GAME("Game"),
    END("End");

    private String text = "";

    GameStep(String name){
        this.text = name;
    }

    public String toString(){
        return text;
    }

    public static GameStep fromString(String text) {
        for (GameStep gameStep : GameStep.values()) {
            if (gameStep.text.equalsIgnoreCase(text)) {
                return gameStep;
            }
        }
        return null;
    }

}

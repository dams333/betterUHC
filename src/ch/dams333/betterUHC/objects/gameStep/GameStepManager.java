package ch.dams333.betterUHC.objects.gameStep;

public class GameStepManager {

    private GameStep step = GameStep.PREGAME;

    public void setStep(GameStep gameStep){
        this.step = gameStep;
    }

    public boolean isStep(GameStep gameStep){
        return gameStep == step;
    }

}

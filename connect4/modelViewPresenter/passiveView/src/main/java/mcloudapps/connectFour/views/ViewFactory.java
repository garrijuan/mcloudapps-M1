package mcloudapps.connectFour.views;

public abstract class ViewFactory {

    public abstract BoardView createBoardView();
    public abstract ResultView createResultView();
    public abstract PlayerView createPlayerView();
    public abstract ResumeView createResumeView();
    public abstract StartView createStartView();
    public abstract ErrorView createErrorView();

}

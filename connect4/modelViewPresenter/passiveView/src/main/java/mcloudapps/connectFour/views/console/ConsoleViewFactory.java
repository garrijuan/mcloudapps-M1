package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.views.ViewFactory;

public class ConsoleViewFactory extends ViewFactory{
    
    @Override
    public StartView createStartView() {
        return new StartView();
    }

    @Override
    public PlayerView createPlayerView() {
        return new PlayerView();
    }

    @Override
    public ResumeView createResumeView() {
        return new ResumeView();
    }

    @Override
    public BoardView createBoardView() {
        return new BoardView();
    }

    @Override
    public ResultView createResultView() {
        return new ResultView();
    }

    @Override
    public ErrorView createErrorView() {
        return new ErrorView();
    }

}



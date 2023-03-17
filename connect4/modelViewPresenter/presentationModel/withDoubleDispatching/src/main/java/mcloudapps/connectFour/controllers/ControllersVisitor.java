package mcloudapps.connectFour.controllers;

public interface ControllersVisitor {
    
    void visit(StartController startController);
	void visit(PlayController playController);
	boolean visit(ResumeController resumeController);
}

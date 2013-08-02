package gridframework.controller;

import java.awt.event.KeyEvent;

/**
 * Controller interface in MVC-pattern.
 */
public interface Controller {
    /**
     * Called to inform model of user input
     * @param x 0-based x-index of clicked cell
     * @param y 0-based y-index of clicked cell
     */
    public void cellClicked(int x, int y);

    /**
     * Called to inform model of user input
     * @param event the key user presser
     */
    public void keyPressed(KeyEvent event);

    /**
     * Called to inform model of user input
     * @param event the key user typed
     */
    public void keyTyped(KeyEvent event);

    /**
     * Updates attached views (currently one view supported)
     */
    void updateViews();


}

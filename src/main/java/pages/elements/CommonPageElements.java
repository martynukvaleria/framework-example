package pages.elements;

import readers.LocatorReader;
import org.openqa.selenium.WebDriver;
import pages.elements.forms.*;

public class CommonPageElements {
    LocatorReader reader = new LocatorReader("src/test/resources/locators/commonPage.xml");

    private Label projectRow;
    private TextField name;
    private Button createNewProject;
    private TextField code;
    private Button create;
    private Checkbox access;
    private Button projects;
    private Button openActionsMenu;
    private Button remove;
    private Button okForDelete;
    private Alert alertTxt;
    private Button closeAlert;

    public CommonPageElements(WebDriver webDriver) {
        projectRow = new Label("Project row", reader.getLocator("//commonPage/projectRow"), webDriver);
        createNewProject = new Button("Create new project", reader.getLocator("//commonPage/createNewProject"), webDriver);
        name = new TextField("Name", reader.getLocator("//commonPage/createProject/name"), webDriver);
        code = new TextField("Code", reader.getLocator("//commonPage/createProject/code"), webDriver);
        create = new Button("Create", reader.getLocator("//commonPage/createProject/create"), webDriver);
        access = new Checkbox("Access", reader.getLocator("//commonPage/createProject/accessType"), webDriver);
        projects = new Button("Projects", reader.getLocator("//commonPage/projectsBtn"), webDriver);
        openActionsMenu = new Button("Open actions menu", reader.getLocator("//commonPage/openActionMenu"), webDriver);
        remove = new Button("Remove", reader.getLocator("//commonPage/remove"), webDriver);
        okForDelete = new Button("Ok for delete", reader.getLocator("//commonPage/okForDelete"), webDriver);
        alertTxt = new Alert("Alert", reader.getLocator("//commonPage/alertTxt"), webDriver);
        closeAlert = new Button("Close alert", reader.getLocator("//commonPage/closeAlert"), webDriver);
    }

    public Label getProjectRow() {
        return projectRow;
    }

    public TextField getName() {
        return name;
    }

    public Button getCreateNewProject() {
        return createNewProject;
    }

    public TextField getCode() {
        return code;
    }

    public Button getCreate() {
        return create;
    }

    public Checkbox getAccess(String value) {
        access.replacePartOfLocator("{value}", value);
        return access;
    }

    public Button getProjects() {
        return projects;
    }

    public Button getOpenActionsMenu(String name) {
        openActionsMenu.replacePartOfLocator("{name}", name);
        return openActionsMenu;
    }

    public Button getRemove() {
        return remove;
    }

    public Button getOkForDelete() {
        return okForDelete;
    }

    public Alert getAlertTxt() {
        return alertTxt;
    }

    public Button getCloseAlert() {
        return closeAlert;
    }
}

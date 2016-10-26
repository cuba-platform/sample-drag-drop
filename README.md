# Drag & Drop

This project demonstrates the following concepts of the CUBA platform:

* Extending functionality of screens defined in the platform.
* Using screen companions.
* Adding drag-n-drop functionality to standard CUBA UI components.
 
## Objective

A user should be able to move users between groups in the _Access Groups_ screen using drag-n-drop.

## Solution

* Open the project in CUBA Studio, execute _Run > Create database_, then _Run > Start application server_ and open the application at `http://localhost:8080/app`.

* Open the _Administration > Access Groups_ screen.

* You can drag a user from the table and drop it to a group to move it to this group.

## Implementation Details

* The `com/company/dd/gui/group/group-browse-ext.xml` screen in the GUI module extends the `group-browse.xml` screen of the platform. The screen is registered in the `screens.xml` with the same identifier as the base screen (`sec$Group.browse`), so it will replace the base screen in the application.      

* The `group-browse-ext.xml` screen descriptor defines a companion class for the web client: `com.company.dd.web.group.GroupBrowseCompanion`.

* The `GroupBrowseExt` screen controller defines the interface for the companion and delegates initialization of the drag-n-drop functionality to the companion implementation.

* The `GroupBrowseCompanion.initDragAndDrop()` method obtains Vaadin components from CUBA table and tree and initializes their drag-n-drop parameters.

Based on CUBA Platform 6.3.2
# Project IMT3673: Dog Watcher
## Group members
Abubakar Ahamed Yusuf

Vegard Skaansar
### Idea background
Vegard's older sibling runs a dog daycare, where owners can leave their
dogs instead of having to find a pet sitter. They asked us if we could develop an app that would help
them run and manage the daycare. We set out to make an
application that did just that. What we have created serves as a prototype for
what the final application could be.
### The app's features
* A persistent storage database for storing data about dogs.
* The ability to add new dogs to the database
* The ability to take a picture of a dog, and register it in the database
* The ability to select dogs from a list
* The ability to search for a dog in that list
* The ability to view the registered data of a given dog
* The ability to delete a given dog
* The ability to create a task list for a given date
* The ability to clear tasks from a given date's task list
* The ability to request a notification at a given date.

### How to use
__Homepage__

The first thing you will see upon starting the application.
Here you will see three buttons before you (Dogs, Add and Calendar).
Pressing these buttons will direct you to their respective pages.

__Dogs__

If you pressed the dogs button, you will be directed to a list of all existing dogs in the database.
The page hosts a search field, where you can type in the name of a given dog, rather than scrolling the list
a scrollable list of dogs in the database and two buttons at the bottom (Delete selected, View selected).

* __The search:__ You can type a string into the search field, and the app will try
to find any and all dogs in the database with a name matching that string.
You do not need to type the exact name to gain results.
For example if you want to pick out a dog called "Sally",
and type in "Ally", Sally and any other dogs with a similar name would come up as results.
* __The list:__ Each item in the list consists of an image (if one exists) and the name of a dog.
If you press any of the items in the list, that particular item
will be highlighted green and you will have it selected. You can change which item you currently have selected
at any time by pressing a different item on the list.
* __Delete/View selected:__ If you were to press either of these buttons while you do not have a dog
selected, a message will be displayed and nothing else will happen. If you do have a dog
selected, then the buttons will invoke their respective functions. "Delete selected" will remove
the selected dog from the database and redirect you back to the homepage. "View selected"
will direct you to a page which displays all data about the selected dog.

__Add__

If you pressed the add button, you will be directed to a page where you can input data for a new dog
in the database. You will be asked to input the following fields.

* The dog's name
* The dog's age
* The dog's race
* The owner's name
* The owner's phone number
* The owner's email
* Any special information about the dog, such as illnesses, allergies and etc.
* A checkbox of whether you would wish to take a picture

All the fields are required to be filled in for a dog to be added, however you can choose to leave the
picture checkbox unchecked. The app will check if you input a valid formatted email address. If the address
you inputted is invalidly written, you will be shown an error message. When you press the "Submit" button, assuming all the fields are filled in, you will be directed to your
device's default camera application (assuming you left the "picture" checkbox checked, and that your device
has a camera) and a new dog will be added to the database. After which will be returned to the homepage.

__Calendar__


If you pressed the calendar button, you will be directed to a page where you will see a calendar,
 two buttons (Notify and Todo), the currently selected date and a button at the bottom called "Add items".

* __The calendar:__ You can select a date by pressing any of the dates in the calender
and your choice will be displayed in text, just beneath the calendar. It will also display the todo
 list registered for that given day.
* __Notify:__ When you press this button you will be presented with a form where you can fill in
information for a notification. You specify its title, its description and the time you want
to be notified. After which you press the displayed button.
* __Todo:__ While having a date selected, you can press this button to display the
todo list of that given date, provided one exists.
* __Add item:__ If you press the button, you will be shown a text field, where you can fill in a task
you want to add to the todo list of the selected date.
* __The todo list:__ If you at any point want to delete an item from the todo list, you can do so
by swiping it to the right.

### Known bugs
__Dogs:__
While viewing the dog list, a bug that can somtimes occur is that the list shows itself twice over,
making it look like there is a duplicate of every item in the list. This is not in fact the case,
and when you leave the dogs page and open it again, the list will load the correct amount of
list items again. We are not quite sure what causes this bug.

__Calendar/Notify:__
After filling in the notification form and pressing the button, you may find that nothing appears to outwardly happen, and you are unable to access any of the other elements on the page.
To solve this, simply press back to return to the home page, and return to the calendar page.
Your notification was indeed saved and scheduled despite this bug.

### Technical requirements

Your device having a camera is not required for this application to function. If you check
the picture checkbox in the add page, and try to submit, you will simply add a dog to the database
with an image field set to null.

### Things that could be improved

__Design__

The visual design could definitely be improved upon. Not all UI elements display correctly
and appear slightly off position.

__Image storage__

In the current build, the taking of pictures are outsourced to the device's local camera app,
and are then subsequently processed and saved in the ROOM database. This technically
mean that there exists one processed version of the image taken in the database, and one version of the
image stored in the local file system by the camera app. Meaning we have two images saved in two locations.
An improvement would be to fetch the taken picture's address in the file system, and then save the file address
instead of a BLOB. But then we would have to handle a case of the original image being deleted, rendering
the filepath in the database useless.
# StackOverflowUsers

This project is a tech demo utilizing several popular Android frameworks together. This app gets the top StackOverflow users and displays them in a grid. The user can then tap on the a profile to get more information on a profile page.

* **Retrofit 2** was implemented to allow cleaner network calls to the StackExchange API to acquire user data

* **RxJava** was used to create an Observable Pattern to ensure that the asynchronous network calls were safe and to help efficiency with coding

* **Picasso** was utilized to display images in a grid to make it easier to see the profiles of StackOverFlow Users

* **ViewModel and LiveData**
android architecture components were utilized to ensure only one network call was made and to follow proper clean MVVM design principles.


Future todo items:
* Data caching for offline functionality with Room
* Convert to Single Activity architecture

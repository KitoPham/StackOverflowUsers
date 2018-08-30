# StackOverflowUsers

This project is a protoyping demo to bring the top StackOverflow users into a grid view utilizing different technologies that are 
currently Android staples in the industry.

* **Retrofit 2** was implemented to allow cleaner network calls to the StackExchange API to acquire user data

* **RxJava** was used to create an Observable Pattern to ensure that the asynchronous network calls were safe and to help efficiency with coding

* **Picasso** was utilized to display images in a grid to make it easier to see the profiles of StackOverFlow Users

* **ViewModel and LiveData**
android architecture components were utilized to ensure only one network call was made and to follow proper clean MVVM design principles.

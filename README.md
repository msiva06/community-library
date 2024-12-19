# community-library

### Functional Requirements
* User Registration
* Login/Forgot password
* User profile
* Reserve a Book
* Ready for pickup
* Cancel reservation
* Reminders for book due
* Book Inventory
* Add Books to Inventory
* Remove Book from Inventory

### Non-Functional Requirements
* Low Latency
* Scalability
  * Capacity Estimation
      * Total Users - 200, Daily Active Users - 50
      * Read : Write ratio - 20 : 80 -> 10 : 40 users per day
      * Book Collection - 200, copies - 400
      * Four tables : User, Book, BookInventory, Reservation
          * User Table - 1 KB
          * Book Table - 1 KB
          * BookInventory Table - 1 KB
          * Reservation Table - 1 KB
        Above are single record memory estimation
      * DB Storage
          * User Table - 200 * 1 KB = 200 KB
          * Book Table - 200 * 1 KB = 200 KB
          * BookInventory Table - 400 * 1 KB = 400 KB
          * Reservation Table - 300 KB
          * Estimated DB capacity - 200 + 200 + 400 + 300 = 1100 KB ~ 1 MB
      * Bandwidth
          * Read
              * User Table - 1 KB 
              * BookInventory Table - 400 KB
              * Book Table - 200 KB
              * 1 User = 600 KB, 10 Users = 400 * 10 KB = 4 MB
          * Write
              * Reservation Table - min 2 reservations - 2 KB
              * User Table - 1 KB (updating user profile information)
              * Book Table - min 2 books added - 2 KB
              * Book Inventory - 4 KB
              * 1 User = 10 KB, 40 Users = 40 * 10 = 400 KB
          * Estimated Bandwidth = Read + Write = 4 MB + 4 KB ~ 4 MB/sec

      

  
  
      
  

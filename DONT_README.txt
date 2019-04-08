Dont read Me!!


HOW TO RUN THE CODE:
1. Have Java 1.8 version installed on your system
2. Download code from the GitHub
3. create a Jar file with dependency. (paxos-code-challenge.jar). Your IDE (IntelliJ or Eclipse can do the job)
4. Run the following command
        java -jar <Path_to_Directory>/paxos-code-challenge.jar

5. Use following commands to test (Or use a browser/Rest client)
curl http://localhost:8080/messages/ -X POST -H "Content-Type: application/json" -d '{"message": "foo"}'
curl http://localhost:8080/messages/16b3c4e0d73f06b96c4d86aea5727b8407419dbf496c77b6e0476294a886ed79

6. Additionally I have created another rest service to access the GiftCard problem. You can access the following URL and test the gift card problem.
	curl http://localhost:8080/gifts/splitintotwo -X POST -H "Content-Type: application/json" -d '{
	  "items":["Candy Bar","Paperback Book", "Detergent", "Headphones", "Earmuffs", "Bluetooth Stereo"],
	  "prices":[500, 700, 1000, 1400, 2000, 6000],
	  "giftCard":2500
	}'
	In above json, items will the name of the items and prices array will be prices of the items respectively. And the items/prices are sorted by increasinf prices.
7. You can test the spilitting gift card inot 3, by accessing following REST service.
	curl http://localhost:8080/gifts/splitintothree -X POST -H "Content-Type: application/json" -d '{
	  "items":["Candy Bar","Paperback Book", "Detergent", "Headphones", "Earmuffs", "Bluetooth Stereo"],
	  "prices":[500, 700, 1000, 1400, 2000, 6000],
	  "giftCard":4500
	}'

8. Alternatively, the secod coding challenge can be accessed by running the main class (abhi.coding.ch2.BestGift) by setting the jar file into classpath and executing follwing command
	java abhi.coding.ch2.BestGift <file_name_with_path> <gift_card_value> <Flag_for_split_into_3>
	Note: Flag_for_split_into_3 is optional. Pass 'Y' if you want to split giftcard into 3.

Scaling Question:
First bottleneck in this implementation will be in-memory cache of the hashcode/digests. It will work good for very small scale uses. As users/usages grow, the cache will grow posing memory challenges. We can scale the app to a medium size user base by using a third party cache(e.g.Hazelcast, EhCache). These cache will have the functionality of clearing itself based on LRU (or any other alogorithm).
I have created a facade on the Digester (my service class) and its implementation can be easily replaced. Horizantal scaling will be acheived using a load balancer and multiple nodes of this server.

Deployment Question:
1. Automate the build and deployment process by using various tools avalabile, Jenkins, Jules.
2. Have unit and integerated tests and they should run before the build.
3. Run code analysis tools before check-in to  maintain the code quality.
4. Have well defined check-in process. e.g. Have pull requests to make sure that codes are reviewed before making its way to repository.
5. Have a integeration build process which runs after every check in, to alert any bad check in asap.

Bonus Question [optional]
A. You are considering giving gifts to more people. Instead of choosing exactly 2 items, allow for 3 gifts.
	I have coded for that. Please test that service too.
B. How would you optimize your solution if you could not load the file in memory?
	Playing my opt card.




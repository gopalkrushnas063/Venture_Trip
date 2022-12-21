<h2 align="center">✩░▒▓▆▅▃▂▁📚𝐕𝐞𝐧𝐭𝐮𝐫𝐞 𝐓𝐫𝐢𝐩📚▁▂▃▅▆▓▒░✩</h2>
<h2>Project Summary 📚 :</h2>
<img align="left" width="153" src="https://user-images.githubusercontent.com/103574856/208286121-ecfcf278-948a-4a4c-a912-bfe9f1267dcc.png"/>
<p align="justify">In this project a detailed review of trip management system. The main objectives of this project to know the package related to the trip and journey with best facility and current offer. Searching will be very easy .At a single click will be able to fetch the required data. Nowadays, there are multiple trip packages existing from the various websites to approximately all the locations over the world. A customer demonstrates that it is extremely complicated to search for the multiple of the packages as for significant websites, contact, and communication with the travel agents and more options that exists in it which is a passive method and time-consuming. This project will assist travellers to recommend the best Travel Package among all the packages relevant information such hotel facility, transport facility,Vehicle and description about the package where they want to visit. The trip management system will be helpful for tourism.</p>



<h3>Admin module :</h3>
<li>Admin can manage the user ,traveller,hotel and receive package from traveller & package management</li>
<li align="justify">This module provides administrator related functionality. Administrator manages all information and has access rights to add, delete, edit and view the data related to hotels, travels, routes, bookings, etc.</li>
<h3>User module :</h3>
<li>User can view route,package,give feedback and also booking package.</li>
<li>This module helps to customer.</li>

<hr>

<table align="center">
<tbody>
<tr align="top">
<td width="20%" align="center">

<h3>Software Requirements</h3>
  
| Command | Description |
| --- | --- |
| Operating System | Windows 10, Linux, Mac |
| Programming Language | Java. |
| IDE Used | Intellij , STS |
| Database  | MySQL 8.0 |
| Framework  | SpringBoot,Maven |
| Architecture  | CRUD, MVC |
  
</td>
<td width="20%" align="center">
<h3>Languages and Tools:</h3>
<table align="center">
<tbody>
<tr valign="top">
<td width="15%" align="center">
<p dir="auto"><span>𝗦𝗽𝗿𝗶𝗻𝗴 𝗧𝗼𝗼𝗹 𝗦𝘂𝗶𝘁</span><br><br></p>
<a><img src="https://spring.io/images/logo-spring-tools-gear-3dbfa4e3714afa9d58885422ec7ac8e5.svg" height="40"></a>
<td width="15%" align="center">
<p dir="auto"><span>𝗜𝗻𝘁𝗲𝗹𝗹𝗶𝗝 𝗜𝗗𝗘𝗔</span><br><br></p>
<a><img src="https://upload.wikimedia.org/wikipedia/commons/9/9c/IntelliJ_IDEA_Icon.svg" height = "40"></a>
</td>
<td width="15%" align="center">
<p dir="auto"><span>𝗝𝗮𝘃𝗮</span><br><br></p>
<a><img src="https://cdn.jsdelivr.net/npm/programming-languages-logos/src/java/java.png" height="40"></a>
</td>
<td width="15%" align="center">
<p dir="auto"><span>𝐌𝐲𝐒𝐐𝐋</span><br><br></p>
<a><img src="https://user-images.githubusercontent.com/103574856/208289464-84fa15f0-e608-48f1-82bd-565e0f776243.png" height="40"></a>
</td>
</tr>

<tr valign="top">
<td width="15%" align="center">
<p dir="auto"><span>𝗦𝗽𝗿𝗶𝗻𝗴 𝗕𝗼𝗼𝘁</span><br><br></p>
<a><img src="https://spring.io/images/projects/spring-edf462fec682b9d48cf628eaf9e19521.svg" height="40"></a>
</td>
<td width="15%" align="center">
<p dir="auto"><span>𝐌𝐚𝐯𝐞𝐧</span><br><br></p>
<a><img src="https://user-images.githubusercontent.com/103574856/208289206-2e81be61-cdf4-4667-ac8f-2bacdadefb25.png" height="40"></a>
</td>
<td width="15%" align="center">
<p dir="auto"><span>𝐇𝐢𝐛𝐞𝐫𝐧𝐚𝐭𝐞</span><br><br></p>
<a><img src="https://user-images.githubusercontent.com/103574856/208289363-3db3173b-fdb9-4306-94fa-05290df04561.PNG" height="40"></a>
</td>
</tr>

</td>
</tr>
</tbody>
</table>

</table>

<hr>

<h3 align="center">MySQL Schema Database Structure</h3>
<p align="center"><img src="https://user-images.githubusercontent.com/103574856/208439456-7afc0143-ac45-48d9-84aa-cb49db09d717.png"/></p>

<h3 id="modules">Modules</h3>
    <ul>
        <li>Login, Logout Module</li>
        <li>User Module</li>
        <li>Admin Module</li>
        <li>Booking Management Module</li>
        <li>Feedback Module</li>
        <li>Report Module</li>
        <li>Trip Package Management Module</li>
        <li>Route Mangement Module</li>
    </ul>
    <h3 id="features">Features</h3>
    <ul>
        <li>User and Admin authentication &amp; validation with session uuid having.</li>
        <li>Admin Features:<ul>
                <li>Administrator Role of the entire application</li>
                <li>Only registered admins with valid session token can add/update/delete Package,Hotel,Route or
                    customer from main database.</li>
                <li>Admin can access the details of different Routes, Bus, Packages,
                    TicketDetails,Feedback,Customer,Reports,etc.</li>
            </ul>
        </li>
        <li>User Features:<ul>
                <li>A user can register himself or herself on the platform.</li>
                <li>He/She can check the Packages and Hotels availabilty.</li>
                <li>If Trip Package is available, can book the trip package by providing payment details.</li>
                <li>After booking, he will get booking details for the whole Package inside this there will be all
                    details regarding the ticket details ,total cost, etc.</li>
                <li>If the customer want can cancel the booking.</li>
            </ul>
        </li>
    </ul>
    
   <h3 id="installation-run">Installation &amp; Run</h3>
    <ul>
        <li>Before running the API server, you should update the database config inside the <a
                href="https://github.com/mrFarooque/rightful-order-9279/blob/main/TripManagementSystem/src/main/resources/application.properties">application.properties</a>
            file.</li>
        <li>Update the port number, username and password as per your local database config.</li>
    </ul>
    <pre>
        <code>    server.port=<span class="hljs-number">8888</span>
            spring<span class="hljs-selector-class">.datasource</span><span class="hljs-selector-class">.url</span>=jdbc:mysql:<span class="hljs-comment">//localhost:3306/ventureDB;</span>
            spring<span class="hljs-selector-class">.datasource</span><span class="hljs-selector-class">.driver-class-name</span>=com<span class="hljs-selector-class">.mysql</span><span class="hljs-selector-class">.cj</span><span class="hljs-selector-class">.jdbc</span><span class="hljs-selector-class">.Driver</span>
            spring<span class="hljs-selector-class">.datasource</span><span class="hljs-selector-class">.username</span>=root
            spring<span class="hljs-selector-class">.datasource</span><span class="hljs-selector-class">.password</span>=root
        </code>
    </pre>
    
    
<h3 align="center">Contributors</h3>
<table align="center">
<tbody>
<tr valign="top">

<td width="25%" align="center">
<p dir="auto"><span>Admin Side Developer</span><br><br></p>
<a><img src="https://user-images.githubusercontent.com/103574856/208824189-665b0e8a-d4bf-4b95-97da-4ca4413beb69.png" height="100"></a>
<p dir="auto"><span>Gopal Krushna Sahoo</span><br><br></p>
</td>

<td width="25%" align="center">
<p dir="auto"><span>Admin Side Developer</span><br><br></p>
<a><img src="https://avatars.githubusercontent.com/u/105963524?v=4" height="100"></a>
<p dir="auto"><span>Atal Kumar Pandey</span><br><br></p>
</td>

<td width="25%" align="center">
<p dir="auto"><span>User Side Developer</span><br><br></p>
<a><img src="https://avatars.githubusercontent.com/u/105913917?v=4" height="100"></a>
<p dir="auto"><span>Vedprakash Paswan</span><br><br></p>
</td>

<td width="25%" align="center">
<p dir="auto"><span>User Side Developer</span><br><br></p>
<a><img src="https://user-images.githubusercontent.com/103574856/208824458-76770643-bde5-40e0-836d-03c2e5bde9af.png" height="100"></a>
<p dir="auto"><span>Jainendra Singh</span><br><br></p>
</td>

</tr>
</tbody>
</table>

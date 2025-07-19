<!DOCTYPE html>

<html>

<head>

&nbsp; <title>Hospital Management System - Java Project</title>

</head>

<body>

&nbsp; <h1>🏥 Hospital Management System (Java Project using Deque)</h1>



&nbsp; <p>This is a <strong>Java-based Hospital Management System</strong> that demonstrates how to use:</p>

&nbsp; <ul>

&nbsp;   <li>Java <strong>OOP concepts</strong> (Abstract classes, Interface, Inheritance)</li>

&nbsp;   <li><strong>Collections Framework</strong> (<code>ArrayDeque</code>, <code>ArrayList</code>)</li>

&nbsp;   <li><strong>File Handling</strong> using <code>FileWriter</code></li>

&nbsp;   <li><strong>User Input</strong> with <code>Scanner</code></li>

&nbsp; </ul>



&nbsp; <hr>



&nbsp; <h2>📌 Features</h2>

&nbsp; <ul>

&nbsp;   <li><strong>Add Emergency Patients</strong> (added at the front of the Deque)</li>

&nbsp;   <li><strong>Add Normal Patients</strong> (added at the back of the Deque)</li>

&nbsp;   <li><strong>Serve Patients</strong> (removed from the front — priority-based)</li>

&nbsp;   <li><strong>View All Waiting Patients</strong></li>

&nbsp;   <li><strong>Save All Patients to File</strong> on exit (<code>Hospital\_Data.txt</code>)</li>

&nbsp; </ul>



&nbsp; <hr>



&nbsp; <h2>🧠 Concepts You Will Learn</h2>

&nbsp; <ul>

&nbsp;   <li><strong>Deque Operations</strong>:

&nbsp;     <ul>

&nbsp;       <li><code>addFirst()</code> → Add emergency patients</li>

&nbsp;       <li><code>addLast()</code> → Add normal patients</li>

&nbsp;       <li><code>poll()</code> → Serve next patient (FIFO)</li>

&nbsp;     </ul>

&nbsp;   </li>

&nbsp;   <li><strong>Scanner Issue</strong> (<code>nextInt()</code> vs <code>nextLine()</code>):

&nbsp;     <ul>

&nbsp;       <li>We use <code>sc.nextLine()</code> after <code>sc.nextInt()</code> to clear the newline (<code>\\n</code>) from buffer</li>

&nbsp;     </ul>

&nbsp;   </li>

&nbsp;   <li><strong>File Writing</strong>:

&nbsp;     <ul>

&nbsp;       <li>Using <code>FileWriter</code> to write all patient data to a file</li>

&nbsp;     </ul>

&nbsp;   </li>

&nbsp;   <li><strong>OOP Principles</strong>:

&nbsp;     <ul>

&nbsp;       <li><code>abstract</code> class <code>User</code></li>

&nbsp;       <li><code>interface</code> <code>report</code></li>

&nbsp;       <li>Inheritance with <code>Patient1</code> class</li>

&nbsp;     </ul>

&nbsp;   </li>

&nbsp; </ul>

</body>

</html>

📌 Common Problems Faced

Problem	Reason	Solution

sc.nextLine() skips input	nextInt() leaves a newline	Always use sc.nextLine() after nextInt()

Duplicate id for each patient	id is static and overwritten	Fix: make id non-static or use instance-specific counter

File not saving	Path issues or IO exception	Make sure path is valid and handle IOException properly

Output not shown for display\_d()	display\_d() returns a string	Fix: use System.out.println(p.display\_d());




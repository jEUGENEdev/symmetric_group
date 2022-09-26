<h1>symmetric_group</h1>
<h3>How to use</h5>
<ol>
  <li><a href="https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html">Download</a> Java to your PC (Written in Java 17)</li>
  <li><a href="https://maven.apache.org/download.cgi">Download</a> Maven to your PC (Required for building the project)</li>
  <li>And finally, download the entire project from this repository</li>
  <li>Assemble the project using <code>mvn clean package</code></li>
  <li>Run the assembled project <code>*.jar</code> from the <code>target/</code> folder using <code>java -jar *.jar</code></li>
  <ul><li>Instead of the <code>*</code> character, use the full name of the file</li></ul>
</ol>

<br>

<h3>What to write</h3>
<ul>
  <li>Hm...</li>
  <li>Here the program expects an expression to be input</li>
  <ul>
    <li>Example: <code>(1)(5)(3 2 4) * (3 2 1)(4 5) * (1)(2)(4)(5 3)</code></li>
    <ul>
      <li>Be careful, for some reason the program is not protected from incorrect input</li>
      <li>Example: <s><code>(1 3)(2) * (3)(3) * (5 10)</code></s></li>
      <li>You should understand that it is <b>IMPOSSIBLE</b> to multiply different symmetric groups</li>
      <ul>
        <li><i>No, this is not laziness in validating input data at all...</i></li>
      </ul>
    </ul>
  </ul>
</ul>

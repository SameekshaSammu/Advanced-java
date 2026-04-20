<!DOCTYPE html>
<html>
<head>
    <title>Session Input</title>
</head>
<body>
    <h2>Enter Your Details</h2>
    
    <form action="setSession.jsp" method="post">
        Name: <input type="text" name="username" required><br><br>
        
        Session Time (in minutes): 
        <input type="number" name="time" required><br><br>
        
        <input type="submit" value="Submit">
    </form>
</body>
</html>
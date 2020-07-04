<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>update task</title>
<link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css"
    rel="stylesheet">

</head>
<body>
    <div class="container">
        <H1>update your task!</H1>
    
        <form:form method="POST" commandName="todo">
            
            <fieldset class="form-group">
                <form:label path="description">Description:</form:label>
                <!-- required validates nulll -->
                <form:input path="description" type="text" class="form-control"
                    required="required" />
                <form:errors path="description" cssClass="text-warning" />
            </fieldset>

            <fieldset class="form-group">
                <form:label path="targetDate">Target Date</form:label>
                <form:input path="targetDate" type="Date" class="form-control"
                    required="required" />
                <form:errors path="targetDate" cssClass="text-warning" />

            </fieldset>
            <fieldset class="form-group">
                <form:radiobutton path="completion" value="true" />
                <form:radiobutton path="completion" value="false" />
                <form:errors path="targetDate" cssClass="text-warning" />
            </fieldset>

            <button type="submit" class="btn btn-success">Submit Update</button>
        </form:form>
        
    </div>
    <script src="webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>

</body>
</html>

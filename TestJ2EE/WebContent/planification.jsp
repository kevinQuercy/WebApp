<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Planification</title>
	</head>
	<body>
		<form method="post" action="1">
            <fieldset>
                <legend>Planification</legend>
                <p>Veuillez définir un taux de remplissage svp.</p>

				<label for="taux">Taux de remplissage</label>
                <input type="text" id="taux" name="taux" value="" size="10" maxlength="10" />
                <br />

                <input type="submit" value="Planifier" class="sansLabel" />
                <br />
            </fieldset>
        </form>
        
        
	</body>
</html>
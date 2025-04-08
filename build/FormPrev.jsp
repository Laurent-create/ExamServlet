<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajout de Prévision</title>

    <style>
        
        body {
            height: 100vh;
            width: 100%;
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            text-align: center;
        }

        .main{
            height: 100%;
            width: 100%;
        }

        h1 {
            color: #333;
        }

        form {
            width: 20%;
            margin: 20px auto;
            padding: 25px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: left;
        }

        div {
            margin-bottom: 15px;
        }

        label {
            font-size: 16px;
        }

        input, select {
            width: 95%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            width: 100%;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }

        .error {
            color: red;
            font-weight: bold;
        }
    
    </style>
</head>
<body>
    <div class="main">
        <h1>Formulaire d'ajout de Prévision</h1>

        <form action="Prev" method="POST">
            <div>
                <label for="libelle">Libelle :</label>
                <input type="text" id="libelle" name="libelle" placeholder="Ex : Frais Bus" required>
            </div>

            <div>
                <label for="montant">Montant :</label>
                <input type="text" id="montant" name="montant" placeholder="Ex : 100000" required>
            </div>
        
            <div>
                <button type="submit">Ajouter</button>
            </div>
        </form> 

        <% 
            String error = request.getParameter("error");
            if ("missing_name".equals(error)) { 
        %>
            <p class="error">Erreur : Vous devez mettre un libelle.</p>
        <% 
            } else if ("invalid_price".equals(error)) { 
        %>
            <p class="error">Erreur : Montant invalide.</p>
        <% } %>
    </div>   
</body>
</html>

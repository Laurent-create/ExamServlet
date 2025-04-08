<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Connexion</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
        }
        
        .login-container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #eef2f7;
        }
        
        .login-form {
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }

        .login-form h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        .login-form label {
            font-size: 14px;
            color: #555;
            margin-bottom: 5px;
            display: block;
        }

        .login-form input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 16px;
            box-sizing: border-box;
        }

        .login-form button {
            width: 100%;
            padding: 12px;
            background-color: #4CAF50;
            border: none;
            border-radius: 4px;
            color: white;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .login-form button:hover {
            background-color: #45a049;
        }

        .error-message {
            color: red;
            font-size: 14px;
            margin-bottom: 15px;
            text-align: center;
        }

        .login-form .form-footer {
            text-align: center;
            margin-top: 10px;
        }

        .login-form .form-footer a {
            color: #007BFF;
            text-decoration: none;
        }

        .login-form .form-footer a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <div class="login-container">
        <div class="login-form">
            <h2>Connexion</h2>

            <!-- Affichage du message d'erreur si la connexion échoue -->
            <div class="error-message">
                <!-- Ici on affichera le message d'erreur -->
                ${errorMessage}
            </div>

            <form action="Login" method="post">
                <label for="nom">Nom d'utilisateur</label>
                <input type="text" id="nom" name="nom" required value="laurent">

                <label for="mdp">Mot de passe</label>
                <input type="password" id="mdp" name="mdp" required value="bgdemada">

                <button type="submit">Se connecter</button>
            </form>

            <div class="form-footer">
                <p>Pas encore inscrit ? <a href="Login?Pass=true">Entrer sans Login</a></p>
            </div>
        </div>
    </div>

</body>
</html>

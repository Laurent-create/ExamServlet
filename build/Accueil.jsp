<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion des Employés et Départements</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        body {
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        main {
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
            width: 300px;
        }

        h1 {
            margin-bottom: 15px;
            font-size: 20px;
            color: #333;
        }

        .btn-container {
            display: flex;
            flex-direction: column;
            gap: 10px;
        }

        .btn {
            display: block;
            width: 100%;
            padding: 12px;
            text-align: center;
            font-size: 16px;
            color: white;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            transition: 0.3s ease;
        }

        .btn:hover {
            background-color: #0056b3;
        }

        .btn-secondary {
            background-color: #28a745;
        }

        .btn-secondary:hover {
            background-color: #1e7e34;
        }
    </style>
</head>
<body>
    <main>
        <h1>Gestion des Données</h1>
        <div class="btn-container">
            <a href="FormPrev" class="btn">Formulaire Prevision</a>
            <a href="FormDep" class="btn">Formulaire Depense</a>
            <a href="Dash" class="btn">Dashboard</a>
        </div>
    </main>
</body>
</html>

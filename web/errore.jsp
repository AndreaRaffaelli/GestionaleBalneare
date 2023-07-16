<!DOCTYPE html>
<html>
<head>
  <title>Errore</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #FFE7A0;
      color: #333;
      margin: 0;
      padding: 0;
    }
    
    .header-banner {
      background-color: #30A2FF;
      color: #fff;
      padding: 10px;
      text-align: left;
      font-size: 24px;
    }

    .container {
      max-width: 800px;
      margin: 0 auto;
      padding: 20px;
      margin-bottom: 160px; 
    }

    form {
      margin-top: 40px;
    }

    label {
      display: block;
      margin-bottom: 5px;
    }

    input[type="text"],
    input[type="date"],
    select {
      width: 50%;
      padding: 8px;
      border: none;
      border-radius: 4px;
      background-color: #f5f5f5;
      box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
    }

    textarea {
      width: 100%;
      padding: 8px;
      border: none;
      border-radius: 4px;
      background-color: #f5f5f5;
      box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
    }

    select[name="name-surname"],
    select[name="position"],
    select[name="object"] {
      height: 35px;
    }

    button {
      background-color: #30A2FF;
      color: #fff;
      border: none;
      padding: 10px 20px;
      border-radius: 4px;
      cursor: pointer;
      margin-top: 10px;
    }

    button:hover {
      background-color: #178ACB;
    }

    .message {
      margin-top: 20px;
      padding: 10px;
      background-color: #F5F5F5;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    .success {
      background-color: #D4EDDA;
      color: #155724;
      border-color: #C3E6CB;
    }

    .error {
      background-color: #F8D7DA;
      color: #721C24;
      border-color: #F5C6CB;
    }

    .right-align {
      float: right;
    }
    
    .footer {
      background-color: #30A2FF;
      color: #fff;
      padding: 10px;
      text-align: center;
      font-size: 14px;
      position: fixed; 
      bottom: 0;
      left: 0;
      right: 0;
    }
  </style>
</head>
<body>

  <div class="header-banner">
    <h1 style="font-size: 24px; margin-left: 10%;">Errore - Gestionale Balneare</h1>
  </div>

  <div class="container">
    <h2 style="color: #721C24;">${tipoErrore}</h2>
    <p style="color: #721C24;">${messaggioErrore}</p>
    <!-- testa se funziona -->
    <p><a href="javascript:history.back()" class="back-link">Torna indietro</a></p>
  </div>

  <div class="footer">
    <p style="font-size: 14px;">&copy; 2023 Gestionale Balneare</p>
  </div>
</body>
</html>

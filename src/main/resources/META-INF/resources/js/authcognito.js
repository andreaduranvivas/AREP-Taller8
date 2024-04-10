const AWS = require('aws-sdk');

const cognito = new AWS.CognitoIdentityServiceProvider({
    region: 'us-east-1', // Reemplaza con tu región
    userPoolId: 'us-east-1_1234567890', // Reemplaza con tu ID de grupo de usuarios
});

const params = {
    ClientId: '4t926nlb1th8s4afb0dolcakoo', // Reemplaza con tu ID de cliente
    Code: '7cc2c555-24b5-4e1d-9716-eabf8d0a2b10', // Reemplaza con el código de la URL
    RedirectURI: 'http://localhost:8080/mainPage.html', // Reemplaza con tu URI de redirección
};

cognito.initiateAuth(params, (err, data) => {
    if (err) {
        console.log(err);
        return;
    }

    console.log(data.AccessToken); // Muestra el token de acceso
});

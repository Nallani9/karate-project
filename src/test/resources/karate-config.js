function fn() {
	var env = karate.env;
	karate.log('karate.env system property was:', env);

	if (!env || !['dit', 'dev', 'uat', 'qa', 'pac', 'perf', 'prod'].includes(env)) {
		karate.log('WARN: Invalid or missing environment! Fallback to local. Allowed values: dit, dev, qa, uat, pac, perf, prod');
		env = 'local';
	}
	karate.log('The current env is :', env);
	var clientId = karate.properties['clientId'];
	var clientSecret = karate.properties['clientSecret'];
	if (!clientId || !clientSecret) {
		karate.log('ERROR: clientId or clientSecret not provided')
		throw new Error("OAuth credentials missing during the beginning of test")
	}

	var config = {
		ssl: {
			trustStore: 'classpath:truststore.jks'
		}
	};
	karate.configure('ssl', {
		trustStore: config.ssl.trustStore
	});

	if (env == 'local') {
		config.baseUrl = 'http://localhost:8080';
		config.oauthBaseUrl = 'http://localhost:8080';
		config.clientId = clientId;
		config.clientSecret = clientSecret;
	} else if (env == 'dit' || env == 'dev') {
		config.baseUrl = 'http://localhost:8080';
		config.oauthBaseUrl = 'http://localhost:8080';
		config.clientId = clientId;
		config.clientSecret = clientSecret;
	} else if (env == 'uat' || env == 'qa') {
		config.baseUrl = 'http://localhost:8080';
		config.oauthBaseUrl = 'http://localhost:8080';
		config.clientId = clientId;
		config.clientSecret = clientSecret;
	}

	if (!karate.properties['accessToken']) {
		var authResponse = karate.callSingle('classpath:features/oauth.feature', {
			oauthBaseUrl: config.oauthBaseUrl,
			clientId: config.clientId,
			clientSecret: config.clientSecret
		});
		karate.properties['accessToken'] = authResponse.accessToken;
	}

	karate.configure('headers', {
		Authorization: 'Bearer' + karate.properties['accessToken']
	});

	karate.configure('connectTimeout', 5000);
	karate.configure('readTimeout', 5000);
	return config;
}
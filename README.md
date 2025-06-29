keytool -genkeypair -alias server -keyalg RSA -keysize 2048 -keystore server-keystore.jks -validity 365
keytool -exportcert -alias server -keystore server-keystore.jks -file server-cert.cer
keytool -genkeypair -alias client -keyalg RSA -keysize 2048 -keystore client-keystore.jks -validity 365
keytool -exportcert -alias client -keystore client-keystore.jks -file client-cert.cer
keytool -importcert -alias server -file server-cert.cer -keystore client-keystore.jks
keytool -importcert -alias client -file client-cert.cer -keystore server-keystore.jks

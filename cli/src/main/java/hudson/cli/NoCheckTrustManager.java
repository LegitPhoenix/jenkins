package hudson.cli;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/**
 * @author Kohsuke Kawaguchi
 * @deprecated This class disables certificate validation entirely, enabling man-in-the-middle attacks.
 * It should not be used. Use proper certificate validation with the system trust store instead.
 * This class is retained only for backward compatibility and will be removed in a future version.
 */
@Deprecated
public class NoCheckTrustManager implements X509TrustManager {
    @Override
    @SuppressFBWarnings(value = "WEAK_TRUST_MANAGER", justification = "User set parameter to skip verifier.")
    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
        throw new CertificateException("NoCheckTrustManager is deprecated and insecure. Certificate validation has been disabled, which allows man-in-the-middle attacks. Use proper certificate validation instead.");
    }

    @Override
    @SuppressFBWarnings(value = "WEAK_TRUST_MANAGER", justification = "User set parameter to skip verifier.")
    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
        throw new CertificateException("NoCheckTrustManager is deprecated and insecure. Certificate validation has been disabled, which allows man-in-the-middle attacks. Use proper certificate validation instead.");
    }

    @Override
    @SuppressFBWarnings(value = "WEAK_TRUST_MANAGER", justification = "User set parameter to skip verifier.")
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}

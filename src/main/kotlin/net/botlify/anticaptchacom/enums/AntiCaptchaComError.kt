package net.botlify.anticaptchacom.enums

import com.fasterxml.jackson.annotation.JsonValue

/**
 * This enum follows the documentation of the AntiCaptchaCom API.
 * @see [Error reference](https://anti-captcha.com/apidoc/errors)
 */
enum class AntiCaptchaComError(@get:JsonValue val value: Int) {
    /**
     * Code 0 is for "no errors".
     */
    NO_ERROR(0),

    /**
     * Account authorization key not found in the system.
     * Make sure you copied it correctly without spaces or tabulation signs.
     */
    ERROR_KEY_DOES_NOT_EXIST(1),

    /**
     * No idle captcha workers are available at the moment;
     * customers should increase their maximum bid in the API settings
     * in the client area or choose less busy hours to create tasks.
     */
    ERROR_NO_SLOT_AVAILABLE(2),

    /**
     * The size of the captcha you are uploading is less than 100 bytes.
     */
    ERROR_ZERO_CAPTCHA_FILESIZE(3),

    /**
     * The size of the captcha you are uploading is more than 500,000 bytes.
     */
    ERROR_TOO_BIG_CAPTCHA_FILESIZE(4),

    /**
     * Account has zero or negative balance.
     */
    ERROR_ZERO_BALANCE(10),

    /**
     * You are not allowed to make requests from your IP with your current account key.
     * Please refer to IP list section located in security settings inside client area.
     */
    ERROR_IP_NOT_ALLOWED(11),

    /**
     * 5 different workers could not solve the Captcha.
     * Customers are charged for these tasks because our workers spend time performing them.
     */
    ERROR_CAPTCHA_UNSOLVABLE(12),

    /**
     * 100% recognition feature did not work because of insufficient number of guesses.
     */
    ERROR_BAD_DUPLICATES(12),

    /**
     * Request made to API with a method that does not exist.
     * This usually happens when programmers mistype method names.
     */
    ERROR_NO_SUCH_METHOD(14),

    /**
     * Could not determine captcha file type from its exif header
     * or the image type is not supported.
     * The only allowed formats are JPG, GIF, PNG.
     * Images must contain an EXIF header containing information about the image type.
     */
    ERROR_IMAGE_TYPE_NOT_SUPPORTED(15),

    /**
     * The captcha you are requesting does not exist in your active captchas list or has expired.
     * Captchas are removed from the API 60 seconds after the worker completes the task.
     * During this period, your app should send all task result polls and correct/incorrect reporting requests.
     */
    ERROR_NO_SUCH_CAPCHA_ID(16),

    /**
     * Your IP is blocked due to improper use of API. Check the reason here.
     */
    ERROR_IP_BLOCKED(21),

    /**
     * "task" property is empty or not set in the createTask method.
     */
    ERROR_TASK_ABSENT(22),

    /**
     * Task type is not supported or typed incorrectly.
     * Please check "type" property in the task object.
     */
    ERROR_TASK_NOT_SUPPORTED(23),

    /**
     * Some of the required values for successive user emulation are missing.
     * API output contains more details about what is missing.
     */
    ERROR_INCORRECT_SESSION_DATA(24),

    /**
     * Could not connect to task proxy, connection refused.
     */
    ERROR_PROXY_CONNECT_REFUSED(25),

    /**
     * Could not connect to task proxy, connection timed out.
     */
    ERROR_PROXY_CONNECT_TIMEOUT(26),

    /**
     * Reading timeout of task's proxy.
     */
    ERROR_PROXY_READ_TIMEOUT(27),

    /**
     * Proxy IP banned by target service.
     */
    ERROR_PROXY_BANNED(28),

    /**
     * Task denied at proxy checking state. Proxy must be non-transparent to hide our server IP.
     * Use our proxy checker tool to debug your proxy.
     */
    ERROR_PROXY_TRANSPARENT(29),

    /**
     * Recaptcha task timeout, probably due to slow proxy server or Google server.
     */
    ERROR_RECAPTCHA_TIMEOUT(30),

    /**
     * Captcha provider reported that the site key is invalid.
     */
    ERROR_RECAPTCHA_INVALID_SITEKEY(31),

    /**
     * Captcha provider reported that the domain for this site key is invalid.
     */
    ERROR_RECAPTCHA_INVALID_DOMAIN(32),

    /**
     * Captcha provider reported that the browser user-agent is not compatible with their javascript.
     */
    ERROR_RECAPTCHA_OLD_BROWSER(33),

    /**
     * Captcha provider server reported that the additional variable token has expired.
     * Please try again with a new token.
     */
    ERROR_TOKEN_EXPIRED(34),

    /**
     * Proxy does not support transfer of image data from Google servers.
     * Use our proxy checker tool to debug your proxy.
     */
    ERROR_PROXY_HAS_NO_IMAGE_SUPPORT(35),

    /**
     * Proxy does not support long GET requests with length about 2000 bytes and does not support SSL connections.
     * Use our proxy checker tool to debug your proxy.
     */
    ERROR_PROXY_INCOMPATIBLE_HTTP_VERSION(36),

    /**
     * Proxy login and password are incorrect. Use our proxy checker tool to debug your proxy.
     */
    ERROR_PROXY_NOT_AUTHORISED(49),

    /**
     * An attempt was made to solve an Invisible Recaptcha as if it was a regular one.
     */
    ERROR_INVISIBLE_RECAPTCHA(51),

    /**
     * Could not load captcha provider widget in worker browser. Please try sending a new task.
     */
    ERROR_FAILED_LOADING_WIDGET(52),

    /**
     * Attempted solution of usual Recaptcha V2 as Recaptcha V2 invisible.
     * Remove flag 'isInvisible' from the API payload.
     */
    ERROR_VISIBLE_RECAPTCHA(53),

    /**
     * No workers left that were not filtered by reportIncorrectRecaptcha method.
     */
    ERROR_ALL_WORKERS_FILTERED(54),

    /**
     * The system has suspended your account for a significant reason. Contact support for details.
     */
    ERROR_ACCOUNT_SUSPENDED(55),

    /**
     * AntiGate template not found by its name during task creation.
     */
    ERROR_TEMPLATE_NOT_FOUND(56),

    /**
     * Worker canceled antiGate task. See "errorDescription" field for the cancellation reason.
     */
    ERROR_TASK_CANCELED(57);
}

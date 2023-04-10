package net.botlify.anticaptchacom.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

@ToString
@EqualsAndHashCode
public class ImageToTextRequest implements SolveRequest {

    /**
     * The type of the request.
     */
    @Getter
    private final String type = "ImageToTextTask";

    /**
     * File body encoded in base64. Make sure to send it without line breaks.
     * Do not include 'data:image/png,' or similar tags, only clean base64!
     */
    @NotNull @Getter
    private final String body;

    /**
     * {@code true}: Requires workers to enter an answer with at least one "space".
     * If there are no spaces, they will skip the task, so use it with caution.<br />
     * {@code false}: No requirements.
     */
    @Getter
    private boolean phrase = false;

    /**
     * {@code false}: No requirements. (Default value)<br />
     * {@code true}: Workers see a special mark indicating that the answer must be entered with case sensitivity.
     */
    @Getter @JsonProperty("case")
    private boolean caseSensitivity = false;

    /**
     * {@code 1}: No requirements. (Default value)<br />
     * {@code 2}: Only numbers are allowed.<br />
     * {@code 3}: Any letters are allowed except numbers.<br />
     */
    @Getter
    private int numeric = 0;

    /**
     * {@code false}: No requirements. (Default value)<br />
     * {@code true}: Workers see a special mark telling them the answer must be calculated.
     */
    @Getter
    private boolean math = false;

    /**
     * {@code 0}: No requirements. (Default value)<br />
     * {@code 1}: Defines minimum length of the answer.<br />
     */
    @Getter
    private int minLength = 0;

    /**
     * {@code 0}: No requirements. (Default value)<br />
     * {@code 1}: Defines maximum length of the answer.<br />
     */
    @Getter
    private int maxLength = 0;

    /**
     * Additional comments for workers like "enter red text".<br />
     * The result is not guaranteed and is totally up to the worker.
     */
    @Getter @Nullable
    private String comment;

    /**
     * Optional parameter to distinguish source of image captchas in spending statistics.
     */
    @Getter @Nullable
    private String websiteURL;

    /**
     * Construct a new {@link ImageToTextRequest}.
     * @param body File body encoded in base64. Make sure to send it without line breaks.
     * Do not include 'data:image/png,' or similar tags, only clean base64!
     */
    public ImageToTextRequest(@NotNull final String body) {
        this.body = body;
    }

    /**
     * {@code true}: Requires workers to enter an answer with at least one "space".
     * If there are no spaces, they will skip the task, so use it with caution.<br />
     * {@code false}: No requirements.
     * @param phrase The phrase.
     * @return This request.
     */
    public @NotNull ImageToTextRequest setPhrase(final boolean phrase) {
        this.phrase = phrase;
        return this;
    }

    /**
     * {@code false}: No requirements. (Default value)<br />
     * {@code true}: Workers see a special mark indicating that the answer must be entered with case sensitivity.
     * @param caseSensitivity The case sensitivity.
     * @return This request.
     */
    public @NotNull ImageToTextRequest setCaseSensitivity(final boolean caseSensitivity) {
        this.caseSensitivity = caseSensitivity;
        return this;
    }

    public @NotNull ImageToTextRequest setNumeric(@Range(from = 0, to = 2) final int numeric) {
        this.numeric = numeric;
        return this;
    }

    public @NotNull ImageToTextRequest setMath(final boolean math) {
        this.math = math;
        return this;
    }

    public @NotNull ImageToTextRequest setMinLength(@Range(from = 0, to = Integer.MAX_VALUE) final int minLength) {
        this.minLength = minLength;
        return this;
    }

    public @NotNull ImageToTextRequest setMaxLength(@Range(from = 0, to = Integer.MAX_VALUE) final int maxLength) {
        this.maxLength = maxLength;
        return this;
    }

    /**
     * Additional comments for workers like "enter red text".<br />
     * The result is not guaranteed and is totally up to the worker.
     * @param comment The comment.
     * @return This request.
     */
    public @NotNull ImageToTextRequest setComment(@Nullable final String comment) {
        this.comment = comment;
        return this;
    }

    /**
     * Optional parameter to distinguish source of image captchas in spending statistics.
     * @param websiteURL The website URL.
     * @return This request.
     */
    public @NotNull ImageToTextRequest setWebsiteURL(@Nullable final String websiteURL) {
        this.websiteURL = websiteURL;
        return this;
    }

}

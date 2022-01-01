/*
 * Copyright 2020 Miroslav Pokorny (github.com/mP1)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package walkingkooka.tree.expression.function.string;

import org.junit.jupiter.api.Test;
import walkingkooka.Cast;
import walkingkooka.tree.expression.function.ExpressionFunctionContext;
import walkingkooka.tree.expression.function.ExpressionFunctionContexts;

import static org.junit.jupiter.api.Assertions.assertThrows;

public final class StringExpressionFunctionUnaryLowerCaseTest extends StringExpressionFunctionUnaryTestCase<StringExpressionFunctionUnaryLowerCase<ExpressionFunctionContext>> {

    @Test
    public void testString() {
        this.applyAndCheck2(parameters("abc123"), "abc123");
    }

    @Test
    public void testString2() {
        assertThrows(UnsupportedOperationException.class, () -> this.createBiFunction().applyString("A", ExpressionFunctionContexts.fake()));
    }

    @Test
    public void testStringUpperCased() {
        this.applyAndCheck2(parameters("ABC123"), "abc123");
    }

    @Test
    public void testStringMixed() {
        this.applyAndCheck2(parameters("abcDEF"), "abcdef");
    }

    @Test
    public void testToString() {
        this.toStringAndCheck(this.createBiFunction(), "lower-case");
    }

    @Override
    public StringExpressionFunctionUnaryLowerCase<ExpressionFunctionContext> createBiFunction() {
        return StringExpressionFunctionUnaryLowerCase.instance();
    }

    @Override
    public Class<StringExpressionFunctionUnaryLowerCase<ExpressionFunctionContext>> type() {
        return Cast.to(StringExpressionFunctionUnaryLowerCase.class);
    }
}
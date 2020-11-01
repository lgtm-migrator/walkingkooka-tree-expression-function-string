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
import walkingkooka.tree.expression.function.ExpressionFunctionContext;

import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class UnaryStringExpressionFunctionTestCase<F extends UnaryStringExpressionFunction<T, ExpressionFunctionContext>, T> extends StringExpressionFunctionTestCase<F, T> {

    UnaryStringExpressionFunctionTestCase() {
        super();
    }

    @Test
    public final void testZeroParametersFails() {
        assertThrows(IllegalArgumentException.class, this::apply2);
    }

    @Test
    public final void testTwoParametersFails() {
        assertThrows(IllegalArgumentException.class, () -> this.apply2("a1", "b2"));
    }

    @Test
    public final void testThreeParametersFails() {
        assertThrows(IllegalArgumentException.class, () -> this.apply2("a1", "b2", "c3"));
    }
}

/*
 * Copyright 2022 Miroslav Pokorny (github.com/mP1)
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

/*
 * Copyright 2019 Miroslav Pokorny (github.com/mP1)
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

import static org.junit.jupiter.api.Assertions.assertThrows;

public final class StringExpressionFunctionConcatTest extends StringExpressionFunctionTestCase<StringExpressionFunctionConcat<ExpressionFunctionContext>, String> {

    @Test
    public void testZeroParametersFails() {
        assertThrows(IllegalArgumentException.class, this::apply2);
    }

    @Test
    public void testOneString() {
        this.applyAndCheck2(parameters("a1"), "a1");
    }

    @Test
    public void testTwoStrings() {
        this.applyAndCheck2(parameters("a1", "b2"), "a1b2");
    }

    @Test
    public void testThreeStrings() {
        this.applyAndCheck2(parameters("a1", "b2", "c3"), "a1b2c3");
    }

    @Test
    public void testFourStrings() {
        this.applyAndCheck2(parameters("a1", "b2", "c3", "d4"), "a1b2c3d4");
    }

    @Test
    public void testToString() {
        this.toStringAndCheck(this.createBiFunction(), "concat");
    }

    @Override
    public StringExpressionFunctionConcat<ExpressionFunctionContext> createBiFunction() {
        return StringExpressionFunctionConcat.instance();
    }

    @Override
    public Class<StringExpressionFunctionConcat<ExpressionFunctionContext>> type() {
        return Cast.to(StringExpressionFunctionConcat.class);
    }
}

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

import walkingkooka.tree.expression.ExpressionPurityContext;
import walkingkooka.tree.expression.function.ExpressionFunction;
import walkingkooka.tree.expression.function.ExpressionFunctionContext;
import walkingkooka.tree.expression.function.ExpressionFunctionParameter;
import walkingkooka.tree.expression.function.ExpressionFunctionParameterName;

import java.util.List;

/**
 * A function that requires 2 string parameters and returns a {@link Boolean} result.
 */
abstract class StringStringBooleanExpressionFunction<C extends ExpressionFunctionContext> implements ExpressionFunction<Boolean, C> {

    /**
     * Package private ctor
     */
    StringStringBooleanExpressionFunction() {
        super();
    }

    @Override
    public Boolean apply(final List<Object> parameters,
                         final C context) {
        this.checkOnlyRequiredParameters(parameters);

        return this.applyStringString(
                TEXT.getOrFail(parameters, 0),
                this.secondParameter().getOrFail(parameters, 1),
                context
        );
    }

    abstract ExpressionFunctionParameter<String> secondParameter();

    abstract Boolean applyStringString(final String first,
                                       final String second,
                                       final ExpressionFunctionContext context);

    final static ExpressionFunctionParameter<String> TEXT = ExpressionFunctionParameterName.with("text")
            .setType(String.class);

    @Override
    public final boolean lsLastParameterVariable() {
        return false;
    }

    @Override
    public final Class<Boolean> returnType() {
        return Boolean.class;
    }

    @Override
    public final boolean resolveReferences() {
        return false;
    }

    @Override
    public final boolean isPure(final ExpressionPurityContext context) {
        return true;
    }

    @Override
    public final String toString() {
        return this.name().toString();
    }
}

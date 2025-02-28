package org.quiltmc.chasm.lang.api.ast;

import org.jetbrains.annotations.ApiStatus;
import org.quiltmc.chasm.lang.api.eval.Evaluator;
import org.quiltmc.chasm.lang.api.eval.Resolver;
import org.quiltmc.chasm.lang.internal.render.RenderUtil;
import org.quiltmc.chasm.lang.internal.render.Renderer;

public abstract class ValueNode<T> extends Node {
    private T value;

    public ValueNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public void render(Renderer renderer, StringBuilder builder, int currentIndentationMultiplier) {
        if (value instanceof String) {
            builder.append(RenderUtil.quotify((String) value, '"'));
        } else {
            builder.append(value);
        }
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    @ApiStatus.OverrideOnly
    public void resolve(Resolver resolver) {
    }

    @Override
    @ApiStatus.OverrideOnly
    public Node evaluate(Evaluator evaluator) {
        return this;
    }
}

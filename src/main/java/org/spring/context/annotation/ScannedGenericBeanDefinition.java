package org.spring.context.annotation;

import org.spring.beans.factory.annotation.AnnotatedBeanDefinition;
import org.spring.beans.factory.support.GenericBeanDefinition;
import org.spring.core.type.AnnotationMetadata;

public class ScannedGenericBeanDefinition extends GenericBeanDefinition implements AnnotatedBeanDefinition {

	private final AnnotationMetadata metadata;

	public ScannedGenericBeanDefinition(AnnotationMetadata metadata) {
		super();
		
		this.metadata = metadata;
		
		setBeanClassName(this.metadata.getClassName());
	}

	public final AnnotationMetadata getMetadata() {
		return this.metadata;
	}
}
#version 330 core
 
layout(location = 0) in vec4 in_Position;
layout(location = 1) in vec4 in_Color;

uniform mat4 projectionMatrix;
uniform mat4 viewMatrix;
uniform mat4 modelMatrix;

out vec4 pass_Color;

void main(void) {
	gl_Position = in_Position;
	gl_Position = projectionMatrix * viewMatrix * modelMatrix * in_Position;
	pass_Color = in_Color;
}
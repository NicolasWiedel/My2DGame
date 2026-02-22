
// default.frag
#ifdef GL_ES
precision mediump float;
#endif

varying vec4 v_color;
varying vec2 v_uv;

uniform sampler2D u_texture;
uniform float u_time;

void main(){
    vec4 texColor = texture2D(u_texture, v_uv);

    float pulse = 0.5 + 0.5*sin(u_time*2.0);
    vec3 tint = mix(vec3(1.0), vec3(1.0,0.5,0.5),pulse);

    gl_FragColor = texColor*v_color*vec4(tint,1.0);
}


//default vert
attribute vec4 a_position;
attribute vec4 a_color;
attribute vec2 a_texCoordO;

uniform mat4 u_projTrans;
uniform float u_time;

varying vec4 v_color;
varying vec2 v_uv;

void main(){
    //apply a sine wave on Y axis based on xP position and time
    float amplitude = 10.0;
    float frequence = 0.05;
    vec4 pos = a_position;
    pos.y = sin(pos.x*frequence+u_time)*amplitude;

    v_color = a_color;
    v_uv = a_texCoordO;
    gl_Position = u_projTrans*pos;
}

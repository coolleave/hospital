import request from '@/utils/request'

// 查询血液学数据列表
export function listHematology(query) {
  return request({
    url: '/system/hematology/list',
    method: 'get',
    params: query
  })
}

// 查询血液学数据详细
export function getHematology(Id) {
  return request({
    url: '/system/hematology/' + Id,
    method: 'get'
  })
}

// 新增血液学数据
export function addHematology(data) {
  return request({
    url: '/system/hematology',
    method: 'post',
    data: data
  })
}

// 修改血液学数据
export function updateHematology(data) {
  return request({
    url: '/system/hematology',
    method: 'put',
    data: data
  })
}

// 删除血液学数据
export function delHematology(Id) {
  return request({
    url: '/system/hematology/' + Id,
    method: 'delete'
  })
}

export function listHematologyByEncounterId(encounterId) {
  return request({
    url: '/system/hematology/list2',
    method: 'get',
    params: { encounterId }
  })
}